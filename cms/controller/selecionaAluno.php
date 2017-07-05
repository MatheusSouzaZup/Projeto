<?php //Post Params
/*
$id = $_POST['id'];  
$nome = $_POST['nome'];  
$data_nasc = $_POST['data_nasc'];
*/

include("conn.php");

 //SELECT 
 $sql = " SELECT id, nome, data_nasc FROM aluno "; 

 $result = $conn->query($sql); 

 if( $result )
 {
 	$emparry = array();
 		while($row = mysqli_fetch_assoc($result)) {
 			$emparry[] = $row;
 		}
 		echo json_encode($emparry);
 }
 else
 {
 	echo 'Query Failed';
 }

?>