import numpy as np
from selenium import webdriver
 
 
def main():
    url = 'https://www.tianyancha.com/login'
    driver = webdriver.Chrome()
    driver.get(url)
if __name__ == '__main__':
    a = np.ones(3)
    print(a)
    print('java 调用有第三方库的python脚本成功')
    main()