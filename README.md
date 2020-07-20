# ConsoleCRUDApp
Необходимо реализовать консольное CRUD приложение, которое имеет следующие сущности:

Customer
Specialty
Account
AccountStatus (enum ACTIVE, BANNED, DELETED)

Customer-> Set<Specialty> specialties+ Account account
Account -> AccountStatus

В качестве хранилища данных необходимо использовать текстовые файлы:
customers.txt, specialties.txt, accounts.txt

Пользователь в консоли должен иметь возможность создания, получения, редактирования и удаления данных.

Слои:
model - POJO клаcсы
repository - классы, реализующие доступ к текстовым файлам
controller - обработка запросов от пользователя
view - все данные, необходимые для работы с консолью

Например: Customer, CustomerRepository, CustomerController, CustomerView и т.д.


Для репозиторного слоя желательно использовать базовый интерфейс:
interface GenericRepository<T,ID>

interface CustomerRepository extends GenericRepository<Customer, Long>

class JavaIOCustomerRepositoryImpl implements CustomerRepository

Результатом выполнения задания должен быть отдельный репозиторий с README.md файлом, который содержит описание задачи, проекта и инструкции запуска приложения через командную строку.
