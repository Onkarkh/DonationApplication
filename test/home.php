<?php
require 'conn.php';

$sql = "Select * from donation_database";
$result = mysqli_query($conn,$sql);
echo "<html><head>
<style>
*{
	font-family: Cambria, Georgia, serif;
}
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
th, td {
  padding: 5px;
  text-align: left;    
}
</style>
<head><body>
<table border='1'>
<tr>
<th>Firstname</th>
<th>Lastname</th>
<th>Email</th>
<th>Mobile</th>
<th>Address</th>
<th>Type</th>
<th>Other</th>
<th>Quantity</th>
</tr>";
	while($row = mysqli_fetch_assoc($result)){
		echo "<tr>";
echo "<td>" . $row['firstname'] . "</td>";
echo "<td>" . $row['lastname'] . "</td>";
echo "<td>" . $row['email'] . "</td>";
echo "<td>" . $row['mobile'] . "</td>";
echo "<td>" . $row['address'] . "</td>";
echo "<td>" . $row['type'] . "</td>";
echo "<td>" . $row['other'] . "</td>";
echo "<td>" . $row['quantity'] . "</td>";
echo "</tr>";
	}
	echo "</body></html>";
mysqli_close($conn);
?>