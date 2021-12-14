# jmpp311

**Вопросы к ментору**
<li>Вызовы методов JPA-репозитория делать из слоя UserService или UserDao?</li>

**2021.12.14**
<li>Подключил валидацию к html-форме параметров пользователя</li>

**2021.12.12**
<li>Обращение к JPA-репозиторию реализовал в слое DAO.</li>
<li>Долго разбирался почему thymeleaf на находит шаблоны html. Установил везде WEB-INF/pages и заработало</li>
<li>@Autowired сделал сразу на поля, иначе Spring Boot ругался на циклическое создание бинов</li>

При создании проекта подключил
1. Spring WEB
2. Spring Security
3. Lombok
4. Spring Data JPA
5. MySQL Driver
6. PostgreSQL Driver
7. Позднее в pom.xml добавил Thymeleaf