<?php
// Configuración de la conexión a Oracle
$conn = oci_connect("alu_318218814", "CHAG3182_", "//132.248.59.32/oralab01.fi.unam.mx");
//verifica la conexion de la base de datos
if (!$conn) {
    $e = oci_error();
    trigger_error(htmlentities($e['message'], ENT_QUOTES), E_USER_ERROR);
}

// Inicializar variables
$nombre = '';
$apellido = '';
$error_message = '';

// Verificar si se ha enviado el formulario
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    // Recuperar datos del formulario
    $nombre = isset($_POST['nombre']) ? $_POST['nombre'] : '';
    $apellido = isset($_POST['apellido']) ? $_POST['apellido'] : '';

    // Verificar si se enviaron datos del formulario
    if (!empty($nombre) && !empty($apellido)) {
        // Insertar datos en la base de datos
        $sql = "INSERT INTO prueba (nombre, apellido) VALUES (:nombre, :apellido)";
        $stid = oci_parse($conn, $sql);

        oci_bind_by_name($stid, ':nombre', $nombre);
        oci_bind_by_name($stid, ':apellido', $apellido);

        oci_execute($stid);

        oci_free_statement($stid);

        echo '<h2>Datos Insertados</h2>';
        echo '<p>Nombre: ' . $nombre . '</p>';
        echo '<p>Apellido: ' . $apellido . '</p>';
    } else {
        $error_message = 'Error: Los datos del formulario no fueron enviados correctamente.';
    }
}

oci_close($conn);
?>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Resultado</title>
</head>
<body>

<?php
// Mostrar el mensaje de error solo si hay un error
if (!empty($error_message)) {
    echo '<h2>' . $error_message . '</h2>';
}
?>

</body>
</html>





