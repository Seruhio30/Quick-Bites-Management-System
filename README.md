https://forms.gle/UVVGv74Vt792f6jRA

https://github.com/Seruhio30/Quick-Bites-Management-System.git

Quick-Bites-Management-System
Sitio para el manejo completo de Quick Bites back y front end con mysql, Java e Intellij

Funcionalidades
CRUD para productos (Agregar, Leer, Modificar, Eliminar).
Control de pedidos.
Sistema de gestión de inventarios.
Funcionalidad para registrar ventas y facturación.
Integración con WhatsApp para recibir pedidos.
Requisitos
Java 17+
MySQL
Dependencias de Spring Boot.
Spring Web: Para crear aplicaciones web y RESTful.
Spring Data JPA: Para trabajar con bases de datos a través de JPA (Java Persistence API).
MySQL Driver: Para conectarte a tu base de datos MySQL.
Spring Boot DevTools: Para facilitar el desarrollo (recarga automática).
Spring Security: Si planeas implementar autenticación y autorización en el futuro.
Lombok: Para reducir la verbosidad del código (opcional, pero muy útil).
Spring Boot Starter Validation: Para validar las entradas de datos.
Migraciones
-Flyway

Configuracion de conexion DB
spring.datasource.url=jdbc:mysql://localhost:3306/quickbites_db
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
Back-End
API End Points
Una lista de los endpoints de la API con descripciones y ejemplos de solicitudes y respuestas. Por ejemplo:

POST /api/producto: Crear un nuevo producto.
GET /api/producto: Obtener la lista de productos.
PUT /api/producto/{id}: Actualizar un producto existente.
DELETE /api/producto/{id}: Eliminar un producto.
CRUD para Productos
Product
@Entity: Define que esta clase es una entidad de JPA.
@Id y @GeneratedValue: Generan un identificador único para cada producto.
@Column(nullable = false): Establece que los campos name y price no pueden ser nulos.
@ElementCollection: Define que ingredients es una lista de cadenas (strings) que representa los ingredientes del producto.
image: Una cadena que contendrá la URL de la imagen del producto, para que puedas mostrarla dinámicamente en el frontend.
ProductRepository
JpaRepository<Product, Long>: Aquí, Product es la entidad que estamos gestionando, y Long es el tipo del ID de nuestra entidad.

@Repository: Anotación que indica que esta interfaz es un repositorio y que Spring debe gestionarlo automáticamente. Esto nos proporcionará métodos como:

save(): Para crear o actualizar productos.

findById(): Para buscar un producto por su ID.

findAll(): Para obtener todos los productos.

deleteById(): Para eliminar un producto por su ID.

ProductService
-createProduct(): Crea un nuevo producto.

getAllProducts(): Devuelve una lista con todos los productos.
getProductById(): Busca un producto por su ID.
updateProduct(): Actualiza un producto existente.
deleteProduct(): Elimina un producto por su ID.
ProcutController
@PostMapping: Este método crea un nuevo producto. Recibe un objeto Product en el cuerpo de la solicitud y lo guarda en la base de datos usando el servicio.

@GetMapping: Este método obtiene todos los productos. Llama al servicio para obtener la lista de productos y devuelve un ResponseEntity con la lista.

@GetMapping("/{id}"): Este método obtiene un producto por su ID. Si el producto existe, se devuelve; de lo contrario, responde con 404 Not Found.

@PutMapping("/{id}"): Este método actualiza un producto existente. Recibe el ID del producto y los nuevos detalles en el cuerpo de la solicitud, y los actualiza.

@DeleteMapping("/{id}"): Este método elimina un producto por su ID.

Test en insomnia
##Post

CRUD para Pedidos
Detalles sobre cómo manejar pedidos.

API endpoints necesarios.
Control de Inventarios
Cómo gestionar la materia prima e insumos.
API endpoints necesarios.

Facturación
Cómo se generarán y guardarán las facturas. API endpoints necesarios. Integración de Pedidos desde WhatsApp

Proceso para ingresar pedidos manualmente. Seguridad

Métodos de autenticación y autorización. Conclusiones

Resumen de las funcionalidades y próximos pasos.
