package com.socialmedia.playfab;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.playfab.PlayFabClientAPI;
import com.playfab.PlayFabClientModels;
import com.playfab.PlayFabClientModels.GetFriendsListRequest;
import com.playfab.PlayFabClientModels.GetFriendsListResult;
import com.playfab.PlayFabClientModels.GetPlayerProfileRequest;
import com.playfab.PlayFabClientModels.GetPlayerProfileResult;
import com.playfab.PlayFabErrors.PlayFabResult;

@Controller
public class PlayFabController {

	@GetMapping("/playerProfile")
	@ResponseBody
	public PlayFabResult<GetPlayerProfileResult> getPlayerProfile () {
    	GetPlayerProfileRequest playerProfileRequest = new PlayFabClientModels.GetPlayerProfileRequest();
    	playerProfileRequest.PlayFabId= "D83EEAB610D7F6CD";
    	return PlayFabClientAPI.GetPlayerProfile(playerProfileRequest);
    }
    
	@GetMapping("/friendsList")
	@ResponseBody
	public PlayFabResult<GetFriendsListResult> getFriendsList () {
    	GetFriendsListRequest friendsListRequest = new PlayFabClientModels.GetFriendsListRequest();
    	friendsListRequest.IncludeSteamFriends = true;
    	
    	return PlayFabClientAPI.GetFriendsList(friendsListRequest);
    }
}
