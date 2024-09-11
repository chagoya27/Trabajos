
<?php
// Configuración de la conexión a Oracle
$conn = oci_connect("alu_318218814", "CHAG3182_", "//132.248.59.32/oralab01.fi.unam.mx");
//verifica la conexion de la base de datos
if (!$conn) {
    $e = oci_error();
    trigger_error(htmlentities($e['message'], ENT_QUOTES), E_USER_ERROR);
}

try{

    // Consulta para obtener el nombre de la imagen
    $sql = "SELECT PELICULANOMBRE FROM PELICULA";
    $result = $conn->query($sql);

    $imagenes = array();

    if ($result->num_rows > 0) {
        while ($row = $result->fetch_assoc()) {
            $imagenes[] = $row["PELICULANOMBRE"];
        }
    }
}finally{
    oci_close($conn);
}





?>