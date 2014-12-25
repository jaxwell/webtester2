webtester2
==========
Описание проекта
Система должна проводить как online, так и offline тестирование. Под online
тестированием понимается пошаговый(wizard) вывод на экран вариантов вопросов. Под
offline понимается возможность вывести все эти вопросы в виде доступном для печати, с
последующей проверкой результата online(преподавателем). Причём сначала должна
быть реализована функциональность offline, а после Online тестирования.
1. Роли в системе: student, tutor, advanced tutor, administrator
2. Каждый пользователь в системе может иметь одну, несколько, либо все роли
(отсутствие ролей у пользователя не допустимо).
3. Назначение ролей производит пользователь с ролью administrator.
4. Права всех ролей, присвоенных пользователю, суммируются (например: если
administrator хочет пройти тест ему необходимо назначить роль student, а если
создать - tutor)
5. Если у пользователя есть роль advanced tutor, то у него автоматически есть роль
tutor.
6. Вначале в системе должен быть только один пользователь, только с ролью
administrator, с login=admin, password=admin
7. Каждый зарегистрированный пользователь может:
a. Просмотреть свои регистрационные данные
b. Изменить свои данные (кроме login), email при изменении - должен быть
уникальным в системе
c. Просмотреть результаты своих тестов
Регистрация
Каждый пользователь системы должен пройти регистрацию. При регистрации
необходимо ввести как минимум следующие данные: логин, пароль, ФИО, адрес
электронной почты. Логин и адрес должны быть уникальными в системе. После ввода
этих данных, на указанный адрес высылается письмо для подтверждения регистрации со
ссылкой для активации пользователя системы. Если пользователь не подтвердил свою
регистрацию в течение 24 часов — информация о нём стирается из БД. После активации
пользователя ему по умолчанию присваивается только роль student.
Установление подлинности пользователя
Осуществляется с помощью страницы, на которой пользователю необходимо ввести
логин и пароль. На этой странице должна быть ссылка на страницу восстановления
пароля.
Восстановление пароля
На этой странице должна быть возможность ввода email, на который будет выслан логин
и пароль соответствующий данному почтовому ящику. Система восстановления пароля по
специальному вопросу — не предусматривается.
Возможности пользователя с ролью administrator
1. Добавлять пользователей
