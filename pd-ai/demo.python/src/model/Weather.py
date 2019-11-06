'''
Created on 2019年11月5日

@author: thinkpad
'''

class WeatherVO:
    location=""
    date=""
    type=""
    low=0
    high=0
    windPower=""
    windDirect=""
    
    def __init__(self):pass
    def __str__(self):
        #return {location:10s}：{0[type]:10s}{0[low]}~{0[high]:10s}{0[fengli]:10s}{0[fengxiang]}'.format(self)
        return "\t"+self.date+"\t"+self.type+"\t"+self.low+"~"+self.high+"\t"+self.windDirect+"\t"+self.windPower
    
class JobDao:pass
    