REM   Script: Activity8
REM   Activity8

select customer_id, max(purchase_amount) from orders group by customer_id;

select customer_id, max(purchase_amount) as "Highest Purchase Amount" from orders group by customer_id;

select * from orders;

select salesman_id, order_date, max(purchase_amount) as "Highest Purchase Amount" from orders WHERE order_date=To_DATE('2012/08/17', 'YYYY/MM/DD') GROUP BY salesman_id, order_date;

SELECT customer_id, order_date, MAX(purchase_amount) AS "Max Amount" FROM orders 
GROUP BY customer_id, order_date 
HAVING MAX(purchase_amount) IN(2030, 3450, 5760, 6000);

