package com.sy.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.rithms.riot.api.ApiConfig;
import net.rithms.riot.api.RiotApi;
import net.rithms.riot.api.RiotApiException;
import net.rithms.riot.api.endpoints.match.dto.MatchList;
import net.rithms.riot.api.endpoints.match.dto.MatchReference;
import net.rithms.riot.api.endpoints.summoner.dto.Summoner;
import net.rithms.riot.constant.Platform;

/**
 * Servlet implementation class SYSearch
 */
@WebServlet("/SYSearch")
public class SYSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SYSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			doReq(request, response);
		} catch (RiotApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			doReq(request, response);
		} catch (RiotApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void doReq(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, RiotApiException {
		// TODO Auto-generated method stub
		
		String sumname = request.getParameter("summoner");
		
		
		ApiConfig config = new ApiConfig().setKey("RGAPI-a3101185-8cdb-420e-a257-9a09ce7ee210");
		RiotApi api = new RiotApi(config);

		// First we need to request the summoner because we will need it's account ID
		Summoner summoner = api.getSummonerByName(Platform.KR, sumname);

		// Then we can use the account ID to request the summoner's match list
		MatchList matchList = api.getMatchListByAccountId(Platform.KR, summoner.getAccountId());

		System.out.println("Total Games in requested match list: " + matchList.getTotalGames());

		// We can now iterate over the match list to access the data
		if (matchList.getMatches() != null) {
			for (MatchReference match : matchList.getMatches()) {
				System.out.println("----------------------------");
				System.out.println("GameID: " + match.getGameId());
				System.out.println("cham:" + match.getChampion());
				System.out.println("lane" + match.getLane());
				System.out.println("sea" + match.getSeason());
				System.out.println("ts" + match.getTimestamp());
				System.out.println("role: "+match.getRole()); ///µà¿À ¼­Æý
				System.out.println("ÇÃ·§Æû¾Æµð"+match.getPlatformId()); 
				System.out.println("Å¥"+match.getQueue());
			}
		}
		
	}

}
