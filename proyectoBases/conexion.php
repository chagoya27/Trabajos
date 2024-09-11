<?php
// Configuración de la conexión a Oracle
$conn = oci_pconnect("alu_318218814", "CHAG3182_", "//132.248.59.32/oralab01.fi.unam.mx");

if (!$conn) {
    $e = oci_error();
    trigger_error(htmlentities($e['message'], ENT_QUOTES), E_USER_ERROR);
}

try {
    // Resto del código aquí
    $imagenes = array();
    // Puedes incluir tu código HTML aquí
    echo '<h2>Formulario de Prueba</h2>';

    echo '<form action="insertar.php" method="post">';
    echo '    <label for="nombre">Nombre:</label>';
    echo '    <input type="text" id="nombre" name="nombre" required>';
    echo '    <br>';
    echo '    <label for="apellido">Apellido:</label>';
    echo '    <input type="text" id="apellido" name="apellido" required>';
    echo '    <br>';
    echo '    <input type="submit" value="Enviar">';
    echo '</form>';

    echo '<h2>Galería de Imágenes</h2>';
    echo '<div class="galeria">';

    
    $sql = 'SELECT PELICULANOMBRE FROM PELICULA';
    $result = oci_parse($conn, $sql);

    
    if (!$result) {
    $e = oci_error($conn);
    trigger_error(htmlentities($e['message'], ENT_QUOTES), E_USER_ERROR);
    }

    oci_execute($result);

    //ESTO ES PARA IMPRIMIR EL RESULTADO DE LA COLUMNA PELICULA NOMBRE
    //while ($row = oci_fetch_assoc($result)) {
    //    $nombrePelicula = $row["PELICULANOMBRE"];
    //    echo '<div>';
    //    echo '<h3>' . $nombrePelicula . '</h3>';
    //    echo '</div>';
    //}

    $imagenes = array();
    $ruta = 'imagenes/';
    $rutacompleta='';
    while ($row = oci_fetch_assoc($result)) {
        $imagenes[] = $row["PELICULANOMBRE"];
    }
    
    //    Mostrar cada imagen en la galería
    foreach ($imagenes as $imagen) {
        echo $rutacompleta;
        $rutacompleta = $ruta . $imagen . '.jpg';
        echo "<img src=\"$rutacompleta\" alt=\"Imagen\">";

    }



} finally {
    // Cerrar la conexión en el bloque finally asegurará que se cierre incluso si hay una excepción
    oci_close($conn);
}
?>