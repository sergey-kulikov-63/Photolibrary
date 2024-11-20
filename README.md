# Photolibrary — это веб-приложение для управления альбомами фотографий. Оно построено с использованием Spring Boot и использует PostgreSQL для хранения данных альбомов и фотографий. Приложение позволяет пользователям создавать альбомы, загружать фотографии и просматривать их.

**Функции:**

Создание альбомов: все пользователи могут создать альбом и "привязать" к нему загруженные пользователем фотографии.

Просмотр альбомов: все пользователи могут просматривать альбомы и их фотографии.

**MainController:**
* redirect (GET /) — перенаправляет на страницу всех альбомов.
* albums (GET /albums) — отображает список всех альбомов.
* album (GET /albums/{id}) — отображает страницу просмотра конкретного альбома с его фотографиями.
* createAlbumPage (GET /albums/create) — страница для создания нового альбома.
* createAlbum (POST /albums/create) — сохраняет новый альбом.
* deleteAlbum (POST /albums/{id}/delete) — удаляет конкретный альбом (по id).

**Модели:**
* Album — модель для альбома, содержит поля для уникального идентификатора, имени альбома и коллекции "входящих" фотографий.
* Photo — модель для фотографии, содержит поля для уникального идентификатора, имени фотографии, её строкового представления и "принадлежность" к альбому.

**Репозитории:**
* AlbumRepo — интерфейс для работы с сущностью альбома.
* PhotoRepo — интерфейс для работы с сущностью фотографии.

**Сервисы:**
* AlbumService — предоставляет функциональность для работы с альбомами через взаимодействие с репозиторием данных AlbumRepo.
  * getAllAlbums() — реализация показа всех альбомов в БД.
  * getAlbumById(Long id) — реализация показа определённого альбома из БД (по id).
  * createAlbum(Album album) — реализация сохранения альбома в БД.
  * deleteAlbum(Long id) — реализация удаления определённого альбома из БД (по id).

* PhotoService — предоставляет функциональность для работы с фотографиями. Он реализует асинхронное сохранение фотографий в базу данных с использованием репозитория PhotoRepo.
  * save(Photo photo) — реализация сохранения фотографии в БД.

**Описание маршрутов:**

        /albums
Главная страница с лентой существующих в БД альбомов.

        /albums/{id}
Страница с содержимым альбома (имя и фотографии альбома).

        /albums/create
Страница для создания нового альбома.

        /posts/{postUrl}/delete
Удаление альбома и всех фото, привязанных к нему. (Кнопка удаления находится на странице просмотра альбома.)
***
**Для запуска веб-приложения необходимо создать новую БД postgres — photolibrary.**

**В psql:** _CREATE DATABASE photolibrary;_