select year(event_date) as year,
	month(event_date) as month,
	sum(income) as income,
	sum(output) as output,
	greatest(sum(ifnull(output,0)-ifnull(income,0)),0) as gap,
	greatest(sum(ifnull(income,0)-ifnull(output,0)),0) as rest
from app_ecnomic_t t0
group by year(event_date),month(event_date) with rollup