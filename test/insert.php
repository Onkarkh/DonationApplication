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

$sql = "INSERT INTO donation_database (firstname,lastname,email,mobile,address,quantity,type,other) VALUES ('$firstName','$lastName','$email','$mobile','$address','$quantity','$type','$other')";
if(mysqli_query($conn,$sql)){
echo "Thank you! We will contact you shortly.";
} else {
	echo "Error: " . $sql . " " . mysqli_error($conn);
}
mysqli_close($conn);
?>