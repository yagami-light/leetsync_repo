# Write your MySQL query statement below

select x, y,z,case when (x+y>z && y+z>x && z+x>y) then  "Yes" Else "No" END as triangle from Triangle