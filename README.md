# StayNest (daxbnb)

Plataforma de reservas de alojamientos al estilo Airbnb/Booking, desarrollada como proyecto académico en pareja.

## Descripción

StayNest permite a los usuarios buscar alojamientos, consultar su disponibilidad, y reservarlos indicando fechas de check-in/check-out y número de huéspedes, con cálculo automático del precio total. Incluye un panel de administración para gestionar el catálogo de alojamientos.

## Funcionalidades

- Registro e inicio de sesión de usuarios
- Listado y búsqueda de alojamientos por tipo y número de habitaciones
- Ficha de detalle de cada alojamiento, con imágenes y servicios (facilities) asociados
- Sistema de reservas con selección de fechas, número de huéspedes y cálculo automático del precio total
- Gestión de tarjetas de crédito asociadas al usuario
- Panel de administración para crear, editar y eliminar alojamientos
- Páginas informativas: FAQ, sobre nosotros, contacto, política de privacidad, reembolsos y términos y condiciones

## Arquitectura y tecnologías

- **Backend:** Java + JSP, patrón DAO con JDBC puro (sin framework ni capa de Servlets)
- **Base de datos:** MySQL — esquema relacional de 9 tablas, incluyendo tablas puente para relaciones muchos a muchos (alojamiento-servicios, alojamiento-imágenes)
- **Frontend:** HTML, CSS y JavaScript

## Equipo

Proyecto desarrollado en colaboración por Alfredo, Jonathan y Diana, trabajando de forma conjunta en frontend, backend, diseño de base de datos y lógica de negocio.

## Estado

Proyecto académico finalizado. Repositorio migrado desde GitLab.
