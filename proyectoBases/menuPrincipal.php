<?php
// Configuración de la conexión a Oracle
$conn = oci_connect("alu_318218814", "CHAG3182_", "//132.248.59.32/oralab01.fi.unam.mx");

if (!$conn) {
    $e = oci_error();
    trigger_error(htmlentities($e['message'], ENT_QUOTES), E_USER_ERROR);
} else {
    try {
        // Puedes incluir tu código HTML aquí
        $sql = 'SELECT PELICULANOMBRE, NOMBREIMAGEN, DESCRIPCION, DIRECCION FROM PELICULA';
        $result = oci_parse($conn, $sql);

        class Pelicula {
            // Propiedades (variables) de la clase
            public $nombrePelicula;
            public $nombreImagenBase; 
            public $descripcionBase; 
            public $direccion; 
            
            // Método constructor
            public function __construct($nombre, $imagen, $descripcion, $dir) {
                $this->nombrePelicula = $nombre;
                $this->nombreImagenBase = $imagen;
                $this->descripcionBase = $descripcion;
                $this->direccion = 'https://'. $dir;
            }
        }

        $arrayPeliculas = array();

        if (!$result) {
            $e = oci_error($conn);
            trigger_error(htmlentities($e['message'], ENT_QUOTES), E_USER_ERROR);
        } else {
            oci_execute($result);

            while (($fila = oci_fetch_assoc($result)) !== false) {
                $nombrePeliculaBase = $fila["PELICULANOMBRE"];
                $nombreImagenBase = $fila["NOMBREIMAGEN"];
                $descripcionBase = $fila["DESCRIPCION"];
                $direccion = $fila["DIRECCION"];
                array_push($arrayPeliculas, new Pelicula($nombrePeliculaBase, $nombreImagenBase, $descripcionBase, $direccion));
            }
        }
    } catch (Exception $ex) {
        // Manejo de excepciones si es necesario
        echo 'Error: ' . $ex->getMessage();
    } finally {
        // Cerrar la conexión en el bloque finally asegurará que se cierre incluso si hay una excepción
        oci_close($conn);
    }
}
?>


        
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="stylesPrincipal.css">
    <title>Axolotl </title>
</head>
<body>

<header class="contenedor">
        <div class="menu">
            <div class="logo">
                <p>CHAIN</p>
            </div>

            <div class="enlaces">
                <a href="#">Inicio</a>
                <a href="#">Acerca de</a>
                <a href="#">Proyectos</a>
                <a href="#">Contacto</a>
            </div>
        </div>
    </header>
    

    <div class="Carousel">
        <h2>Estrenos</h2>
        <div class="slick-list" id="slick-list">
    <button class="slick-arrow slick-prev" id="button-prev" data-button="button-prev" onclick="app.processingButton(event)">
        <svg aria-hidden="true" focusable="false" data-prefix="fas" data-icon="chevron-left" class="svg-inline--fa fa-chevron-left fa-w-10" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 320 512"><path fill="currentColor" d="M34.52 239.03L228.87 44.69c9.37-9.37 24.57-9.37 33.94 0l22.67 22.67c9.36 9.36 9.37 24.52.04 33.9L131.49 256l154.02 154.75c9.34 9.38 9.32 24.54-.04 33.9l-22.67 22.67c-9.37 9.37-24.57 9.37-33.94 0L34.52 272.97c-9.37-9.37-9.37-24.57 0-33.94z"></path></svg>
    </button>
    <div class="slick-track" id="track">

        <?php
        foreach ($arrayPeliculas as $unaPelicula) {
            $rutacompleta = "imagenes/carrousel/" . $unaPelicula->nombreImagenBase . '.png';
        ?>
            <div class="slick" >
                <a href='<?php echo $unaPelicula->direccion; ?>'>
                    <h4><small><?php echo $unaPelicula->nombrePelicula; ?></small>Ver</h4>
                    <picture>
                        <img src='<?php echo $rutacompleta; ?>' alt="Imagen">
                    </picture>
                </a>
            </div>
        <?php
        }
        ?>

    </div>
    <button class="slick-arrow slick-next" id="button-next" data-button="button-next" onclick="app.processingButton(event)">
        <svg aria-hidden="true" focusable="false" data-prefix="fas" data-icon="chevron-right" class="svg-inline--fa fa-chevron-right fa-w-10" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 320 512"><path fill="currentColor" d="M285.476 272.971L91.132 467.314c-9.373 9.373-24.569 9.373-33.941 0l-22.667-22.667c-9.357-9.357-9.375-24.522-.04-33.901L188.505 256 34.484 101.255c-9.335-9.379-9.317-24.544.04-33.901l22.667-22.667c9.373-9.373 24.569-9.373 33.941 0L285.475 239.03c9.373 9.372 9.373 24.568.001 33.941z"></path></svg>
    </button>
</div>

    </div>


    <footer>
        <p>Realizado por Chagoya Gonzalez Leonardo, Carrusel recuperado de : <a href="https://github.com/juliodaal/Carrusel-de-Subcategor-a">juliodaal</a></p>
    </footer>
    <script defer src="main.js"></script>
</body>
</html>




