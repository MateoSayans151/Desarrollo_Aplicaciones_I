# Desarrollo_Aplicaciones_I
# Sistema de Subastas - Aplicación Móvil

Aplicación móvil para participar en subastas en tiempo real y gestionar artículos destinados a futuras subastas.

Este proyecto fue desarrollado como **Trabajo Práctico Obligatorio de Desarrollo de Aplicaciones I**. La aplicación permite a los usuarios registrarse, participar en subastas dinámicas, ofertar por artículos y proponer bienes propios para ser subastados.

---

## 📌 Descripción del Proyecto

La empresa de subastas cuenta con un sistema interno donde se registran las subastas, artículos, postores, ofertas y rematadores.

Esta aplicación móvil se integra con ese sistema existente mediante una **API REST**, permitiendo a los usuarios:

- Participar online en subastas presenciales.
- Realizar ofertas en tiempo real.
- Consultar catálogos de artículos.
- Registrar medios de pago.
- Proponer bienes propios para futuras subastas.

Las subastas siguen el modelo de **subasta dinámica ascendente**, donde los participantes pueden ver las ofertas de otros postores y mejorar la suya mientras la subasta permanezca abierta. :contentReference[oaicite:1]{index=1}

---

# 🧑‍💻 Funcionalidades Principales

## Registro de Usuarios

El registro se realiza en dos etapas:

1. **Registro inicial**
   - Nombre y apellido
   - Documento (foto frente y dorso)
   - Domicilio legal
   - País de origen

2. **Validación por la empresa**
   - Se asigna una categoría al usuario:
     - Común
     - Especial
     - Plata
     - Oro
     - Platino

La categoría determina a qué subastas puede acceder el usuario.

---

## Medios de Pago

Cada usuario debe registrar al menos un medio de pago para participar en subastas:

- Cuenta bancaria
- Tarjeta de crédito
- Cheque certificado

Los medios de pago deben ser **verificados antes de la subasta**.

---

## Participación en Subastas

Cada subasta posee:

- Fecha y hora
- Rematador
- Categoría mínima requerida
- Moneda (ARS o USD)
- Catálogo de artículos

Los usuarios pueden:

- Ver el artículo actual en subasta
- Ver la mejor oferta actual
- Realizar nuevas ofertas

### Reglas de Puja

- La oferta debe ser mayor a la actual.
- Debe superar la oferta actual en **al menos 1% del valor base**.
- No puede superar **20% del valor base sobre la oferta actual**.

Ejemplo:

Precio base: 10.000  
Última oferta: 15.000  

- Oferta mínima: **15.100**
- Oferta máxima: **17.000**

Estas restricciones **no aplican en subastas Oro y Platino**. :contentReference[oaicite:2]{index=2}

---

## Finalización de Subasta

Cuando no se reciben más ofertas:

- El último postor se convierte en el **nuevo propietario del bien**
- Se registra la venta
- Se genera el detalle de pago incluyendo:
  - monto ofertado
  - comisiones
  - envío

Si nadie realiza ofertas, la empresa compra el objeto al **precio base**.

---

## Gestión de Artículos para Subastar

Los usuarios también pueden **proponer artículos propios para subasta**.

Deben proporcionar:

- Descripción del objeto
- Fotografías (mínimo 6)
- Información histórica relevante
- Declaración de propiedad

La empresa puede:

- Aceptar el artículo
- Rechazarlo (indicando motivo)
- Solicitar envío para inspección

Si se acepta:

- Se asigna a una futura subasta
- Se define precio base
- Se establecen comisiones

---

## Métricas y Estadísticas

Los usuarios pueden consultar:

- Subastas en las que participó
- Subastas ganadas
- Historial de pujas
- Importes ofertados
- Categorías de subastas

---

# 🏗️ Arquitectura del Sistema

El sistema se compone de:

### Frontend
Aplicación móvil

Responsabilidades:

- Interfaz de usuario
- Visualización de subastas
- Gestión de ofertas
- Registro y perfil de usuario

### Backend

API REST encargada de:

- Gestión de usuarios
- Catálogo de subastas
- Registro de ofertas
- Validación de reglas de puja
- Integración con sistema interno de la empresa

---

# 🔌 API REST

La API permite:

- Autenticación de usuarios
- Consulta de subastas
- Registro de ofertas
- Gestión de medios de pago
- Registro de artículos

Los endpoints y códigos de respuesta siguen los estándares HTTP.

Ejemplo:
- 200 OK
- 201 Created
- 400 Bad Request
- 401 Unauthorized
- 404 Not Found
- 500 Internal Server Error
