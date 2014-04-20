/* REtun the amout of time spent on the phone for a given user */

select seiz_cell_num_l, sum(conn_dur)
from 
group by seiz_cell_num_l
order by count(conn_dur)

/* See which crcs are being used the most */

select cfc, count(*)
from
where starttime >= 2013
and starttime < 2014
group by cfc
order by count(*)

/* find calls made in alberta */

select starttime, seiz_cell_num_l
from
where ((latitude > 49.002273
and longitude < -109.950672)
or (latitude < 59.949837
and longitude > -119.970203))

/* one with 10 parts to the wher clause */

/* one with one more range query */
