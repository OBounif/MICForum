package com.bounifomar.micforum.models.muser;

public enum UserRankType {
	
	ADMINISTRATOR("Membre personnel"),
	MODERATOR("Membre personnel"),
	FORUM_MODERATOR("Membre personnel"),
	WRITER("Rédacteur"),
	ACTIF_MEMBER("Membre actif"),
	MEMBRE("Membre confirmé"),
	NEWBIE("Newbie");
	
	private String rank_text;
	
	private UserRankType(String type)
	{
		this.rank_text = type;
	}

	public String getType() {
		return rank_text;
	}
	
	
	
}
