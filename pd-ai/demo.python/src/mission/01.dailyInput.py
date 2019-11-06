import pymysql as mdb
import sys

def familyMsg():
    return "familyTest"

def personMsg():
    return "personTest"

def workMsg():
    return "workTest"



def dailyInput():
    print(familyMsg())
    print(personMsg())
    print(workMsg())
    
dailyInput()