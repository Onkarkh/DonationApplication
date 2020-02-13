<?php
require "conn.php";

$firstName = $_POST['firstName'];
$lastName = $_POST["lastName"];
$email = $_POST["email"];
$mobile = $_POST["mobile"];
$address = $_POST["address"];
$quantity = $_POST["quantity"];
$type = $_POST["type"];
$other = $_POST["other"];

//$firstName = "Onkar";
//$lastName = "Khaladkar";
//$email = "Onkar@gmail.com";
//$mobile = "8888238998";
//$address = "Kothrud";
//$quantity = "Quantity";
//$type = "Rice";
//$other = "NUL11L";

$sql = "INSERT INTO donation_database (firstname,lastname,email,mobile,address,quantity,type,other) VALUES ('$firstName','$lastName','$email','$mobile','$address','$quantity','$type','$other')";
if(mysqli_query($conn,$sql)){
echo "New record created successfully !";
} else {
	echo "Error: " . $sql . " " . mysqli_error($conn);
}
mysqli_close($conn);
?>