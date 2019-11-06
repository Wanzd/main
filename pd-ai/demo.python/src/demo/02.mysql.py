import pymysql as mdb
import sys
con = mdb.connect('localhost', 'dev', 'dev', 'dev');
with con:
    cur = con.cursor()
    cur.execute("SELECT * from house_t ")
    rows = cur.fetchall()
    for row in rows:
        print (row)
