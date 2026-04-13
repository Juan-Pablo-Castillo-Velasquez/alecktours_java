# 🔐 Guía de Configuración de Seguridad - AlekTours

## Actualización Realizada en `SecutiryConfig.java`

### ✅ Cambios Implementados

#### 1. **Encriptación de Contraseñas (BCrypt)**
```java
@Bean
public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
}
```
- Las contraseñas ahora se encriptan con **BCrypt** en lugar de estar en texto plano
- Mayor seguridad ante posibles brechas de datos

#### 2. **Rutas Públicas (Sin Autenticación)**
```
✓ /h2-console/**        → Consola H2 (desarrollo)
✓ /swagger-ui/**        → Documentación Swagger
✓ /v3/api-docs/**       → API docs OpenAPI
✓ /api/auth/login       → Login (sin autenticación previa)
```

#### 3. **Control de Acceso por Rol - ADMIN**
Solo los usuarios con rol **ADMIN** pueden:
- **POST** (Crear): `/api/{recurso}`
- **PUT** (Actualizar): `/api/{recurso}/**`
- **DELETE** (Eliminar): `/api/{recurso}/**`

**Recursos protegidos:**
- ✅ Usuarios (`/api/usuarios`)
- ✅ Clientes (`/api/clientes`)
- ✅ Países (`/api/paises`)
- ✅ Ciudades (`/api/ciudades`)
- ✅ Direcciones (`/api/direcciones`)
- ✅ Hoteles (`/api/hoteles`)
- ✅ Paquetes (`/api/paquetes`)
- ✅ Reservas (`/api/reservas`)

#### 4. **Control de Acceso por Rol - USER/ADMIN (Lectura)**
Los usuarios con rol **USER** y **ADMIN** pueden:
- **GET** (Leer): `/api/{recurso}/**`

#### 5. **Usuarios Pre-configurados**

| Usuario | Contraseña  | Rol     | Permisos |
|---------|-------------|---------|----------|
| admin   | admin123    | ADMIN   | Todo (CRUD) |
| user    | user123     | USER    | Solo lectura (GET) |
| manager | manager123  | USER    | Solo lectura (GET) |

### 📋 Matriz de Permisos

| Operación | Recurso | ADMIN | USER |
|-----------|---------|-------|------|
| **GET**   | Todos   | ✅    | ✅   |
| **POST**  | Todos   | ✅    | ❌   |
| **PUT**   | Todos   | ✅    | ❌   |
| **DELETE**| Todos   | ✅    | ❌   |

### 🔐 Cómo Probar con Postman/cURL

#### 1. **Obtener Token (Login)**
```bash
curl -u admin:admin123 http://localhost:8080/api/usuarios/1
```

#### 2. **Crear un Usuario (Solo ADMIN)**
```bash
curl -X POST http://localhost:8080/api/usuarios \
  -H "Authorization: Basic YWRtaW46YWRtaW4xMjM=" \
  -H "Content-Type: application/json" \
  -d '{"username":"newuser","password":"pass","nombre":"Test","email":"test@test.com"}'
```

#### 3. **Ver Recursos (USER puede hacerlo)**
```bash
curl -u user:user123 http://localhost:8080/api/clientes/1
```

#### 4. **Intento de creación con USER (Rechazado)**
```bash
curl -X POST http://localhost:8080/api/usuarios \
  -u user:user123 \
  -H "Content-Type: application/json"
# ❌ Resultado: 403 Forbidden
```

### 🛡️ Características de Seguridad

✅ **CSRF Deshabilitado**: APIs REST típicamente usan tokens JWT/Basic Auth
✅ **H2-Console Permitido**: Solo en desarrollo (considerar remover en producción)
✅ **HTTP Basic Auth**: Compatible con Postman y cURL
✅ **Validación de Rol**: En cada endpoint según el método HTTP
✅ **Encriptación BCrypt**: Contraseñas seguras

### ⚠️ Próximos Pasos (Recomendaciones)

1. **JWT Token**: Implementar JWT en lugar de Basic Auth para producción
2. **Base de Datos**: Cambiar `InMemoryUserDetailsManager` por DB real
3. **CORS**: Configurar CORS si el frontend está en otro dominio
4. **HTTPS**: Usar HTTPS en producción
5. **Roles Adicionales**: Agregar más roles según necesidad

---

**Actualizado**: 2026-04-13
**Proyecto**: AlekTours - Spring Boot MVC
