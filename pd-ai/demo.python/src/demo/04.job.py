from bs4 import BeautifulSoup
from model.Job import JobVO
import json
import requests as req

def getJob(keyword, pages):
        for curPage in range(0, pages):
            url = "https://search.51job.com/list/180200,000000,0000,00,9,99,JAVA,2,1.html?lang=c&stype=&postchannel=0000&workyear=99&cotype=99&degreefrom=99&jobterm=99&companysize=99&providesalary=99&lonlat=0%2C0&radius=-1&ord_field=0&confirmdate=9&fromType=&dibiaoid=0&address=&line=&specialarea=00&from=&welfare="
            # print(url)
            rb = req.get(url)
            rb.encoding = 'GB2312'
            # data = json.loads(rb.text)
            # print(rb.text)
            return rb.text
  
def parseJob(text):
        soup = BeautifulSoup(text, 'lxml')
        # print(soup.prettify())
        divs = soup.select("div[class='el']")
        for eachDiv in divs:
            p = eachDiv.select("p[class='t1']")
            if(len(p) > 0):
                job = JobVO()
                title = p[0].select("a[title]")[0].attrs["title"]
                job.company = eachDiv.select("span[class='t2']")[0].select("a[title]")[0].attrs["title"]
                job.location = eachDiv.select("span[class='t3']")[0].string
                job.salary = salary = eachDiv.select("span[class='t4']")[0].string
                salaryBase = 1000
                salaryBaseStr = salary[-3:]
                if(salaryBaseStr == "万/月"):
                    salaryBase = 10000
                job.salaryRange = salaryRange = salary[:-3].split("-")
                job.salaryFrom = float(salaryRange[0]) * salaryBase
                job.salaryTo = float(salaryRange[1]) * salaryBase
                job.createDate = eachDiv.select("span[class='t5']")[0].string
                print(job)
  
def main():
         jobs = getJob('JAVA', 1)
         parseJob(jobs)
    
main()
