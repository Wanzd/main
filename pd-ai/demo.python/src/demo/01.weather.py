from model.Weather import WeatherVO
import json
import requests as req

def getWeather(location):
    rb = req.get('http://wthrcdn.etouch.cn/weather_mini?city=' + location)
    rb.encoding = 'utf-8'
    data = json.loads(rb.text)
    return data['data']['forecast']
  
def showWeather(location):
    weathers = getWeather(location)
    print(location)
    for each in weathers:
        weather = WeatherVO()
        weather.location = location
        weather.date = each['date']
        weather.type = each['type']
        weather.low = each['low'].replace('低温 ', '')
        weather.high = each['high'].replace('高温 ', '')
        weather.windDirect = each['fengxiang']
        weather.windPower = each['fengli'].replace('<![CDATA[', '').replace(']]>', '')
        print(weather)
  
def main():
    locations = ['黄冈', '武汉', '上海', '深圳']
    for eachLocation in locations:
        showWeather(eachLocation)
        
main()
