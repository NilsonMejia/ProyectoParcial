<h1 align="center">
  📚 Sistema de una biblioteca ambigua 📚
</h1>

<p align="center">
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" alt="Java" width="50"/>
  <img src="https://www.vectorlogo.zone/logos/springio/springio-icon.svg" alt="Spring Boot" width="50"/>
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/mysql/mysql-original.svg" alt="MySQL" width="50"/>
</p>

<p align="center"><i>API RESTful desarrollada con Spring Boot para la gestión de una biblioteca.</i></p>
<h1 align="center">
🧰 Tecnologías utilizadas 🧰 
</h1>

<p align="center">
  <img src="https://img.shields.io/badge/Java_17-ED8B00?style=for-the-badge&logo=java&logoColor=white" alt="Java 17"/>
  <img src="https://img.shields.io/badge/Spring_Boot_3.3.12-6DB33F?style=for-the-badge&logo=springboot&logoColor=white" alt="Spring Boot 3.3.12"/>
  <img src="https://img.shields.io/badge/Maven-CC2222?style=for-the-badge&logo=apachemaven&logoColor=white" alt="Maven"/>
  <img src="https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white" alt="MySQL"/>
  <img src="https://img.shields.io/badge/IntelliJ_IDEA-000000?style=for-the-badge&logo=intellijidea&logoColor=white" alt="IntelliJ IDEA"/>
</p>

## 🚀 Instalación y ejecución del proyecto

### ✅ Requisitos previos

- ☕ Java 17 instalado
- 🧰 Maven instalado
- 🐬 MySQL en ejecución
- 💡 IntelliJ IDEA (o cualquier IDE compatible con Spring Boot)

---

### ⚙️ Pasos para la instalación

1. - Clonar el repositorio
   ```bash
   git clone https://github.com/tu_usuario/ProyectoParcial.git
   cd ProyectoParcial

2. - Ejecutar el script SQL (`/database/script.sql`) en MySQL

```bash
mysql -u [usuario] -p < database/script.sql
 ```
3. - Clonar y vincular con IntelliJ IDEA

### 📥 Clonar repositorio
```bash
git clone https://github.com/tu_usuario/ProyectoParcial.git
cd ProyectoParcial
 ```
4. - Ejecutar el Sistema

### ▶️ Métodos de Ejecución

#### Opción 1: Desde IntelliJ IDEA
1. **Localizar la clase principal**:
   - Buscar el archivo con la anotación `@SpringBootApplication` (normalmente en `src/main/java/com/ejemplo/proyecto`)

2. **Ejecutar**:
   - Click derecho sobre la clase > `Run 'NombreClase'`
   - O usar el botón verde ▶️ en la barra superior
   - Atajo: `Shift + F10`

3. **Verificar consola**:
   ```log
   [main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http)


## 🚀 Guía rápida para usar la API RESTful

Esta guía describe cómo interactuar con los principales endpoints de la API para gestionar libros, usuarios y préstamos.

---

### 🔌 Endpoints principales

| Método | Ruta                           | Descripción                         |
|--------|--------------------------------|-------------------------------------|
| GET    | `/Libro/GetLibro`              | Obtener todos los libros            |
| GET    | `/BuscarLibro/{Titulo}`        | Obtener un libro por titulo         |
| POST   | `/Libro/PostLibro`             | Crear un libro nuevo                |
| PUT    | `/ActualizarLibro/{id}`        | Actualizar un libro                 |
| DELETE | `/delete/{libroID}`            | Eliminar un libro                   |
| GET    | `/Usuario/GetUsuario`          | Obtener todos los usuarios          |
| POST   | `/Usuario/PostUsuarios`        | Crear un usuario nuevo              |
| POST   | `/Prestamo/PostPrestamo`       | Crear un préstamo                   |
| GET    | `/Prestamo/GetPrestamo`        | Listar todos los préstamos          |
| PUT    | `/ActualizarPrestamo/{id}`     | Actualizar un prestamo               |

---

### 🧰 Ejemplos de uso con `curl`

#### 1. Obtener todos los libros

```bash
curl -X GET http://localhost:8080/Libro/Getlibro






   
