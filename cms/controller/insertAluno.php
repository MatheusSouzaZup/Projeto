<?php //GET Params 
$nome = $_GET['nome'];  
$data_nasc = $_GET['data_nasc'];

include("conn.php");

$sql = "INSERT INTO aluno (nome, data_nasc) VALUES ('$nome', '$data_nasc')";

if ($conn->query($sql) === TRUE) {
    echo "New record created successfully";
    return "New record created successfully";
} else {
    //echo "Error: " . $sql . "<br>" . $conn->error;
    //$resp = "Error: ".$sql . "<br>".$conn->error;
    //return json_encode($resp,true);
    return "Error:" .$sql . "<br>" . $conn->error;
}

$conn->close();
?>