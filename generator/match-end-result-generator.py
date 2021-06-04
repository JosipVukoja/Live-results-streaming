import random
import time
import uuid
import requests

def goalsNumberGenerator():
	randomNumber = random.randint(0,7)
	return randomNumber

def teamGenerator():
	teamList = ["Real Madrid","Manchester United","Liverpool","Milan", "Bayern","Barcelona","Dinamo","Juventus","PSG","Zrinjski"]
	randomTeam = random.choice(teamList)
	return randomTeam	

def UUIDGenerator():
	uuid4 = uuid.uuid4()
	return uuid4
	
while 1:			

	firstTeamGoals = goalsNumberGenerator()
	secondTeamGoals = goalsNumberGenerator()

	firstTeam = teamGenerator()
	secondTeam = teamGenerator()
	
	if(firstTeam == secondTeam):
		secondTeam = teamGenerator()
	
	endResult = str(firstTeamGoals) + ':' +  str(secondTeamGoals)

	matchName = firstTeam + '-' + secondTeam
	
	matchID = str(UUIDGenerator())
	
	matchEndResultEvent = { "matchID" : matchID, "matchName" : matchName, "endResult" : endResult }
	
	url = "http://127.0.0.1:8080/api/results"
	
	r=requests.post(url, json=matchEndResultEvent, headers={ 'Content-Type': 'application/json'})
	
	print(matchEndResultEvent)
	
	time.sleep(1)