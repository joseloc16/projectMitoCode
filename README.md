# MITOCODE

# Configuración de Entorno

## Configuración de Docker con MySQL

1. **Descargar la Imagen de MySQL**:
   ```bash
    docker pull mysql:5.7
   
2. **Iniciar Contenedor de MySQL**:
   ```bash
    docker run -d --name my-mysql-mitocode -p 3306:3306 -e MYSQL_ROOT_PASSWORD=123456 -e MYSQL_DATABASE=myProjectDB mysql:5.7
Este comando inicia un nuevo contenedor llamado telegram-bot-container corriendo PostgreSQL y establece las variables de entorno necesarias para la configuración inicial.
