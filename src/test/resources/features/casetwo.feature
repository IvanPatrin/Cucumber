# language: ru
# encoding: utf-8
Функция: Второй кейс
  Предыстория:
    Дано Открыта страница "DNS"
    Когда Перемещение курсора на "Бытовая техника"

  @CheckListLinksStartPage
  Сценарий: Отображение ссылок Встраиваемая техника, Техника для кухни, Техника для дома
    Тогда Проверка: Отображение ссылок Встраиваемая техника, Техника для кухни, Техника для дома
      | Встраиваемая техника |
      | Техника для кухни    |
      | Техника для дома     |

  @CheckSizeListCooking
  Сценарий:  Проверка, что количество ссылок в подменю "Приготовление пищи" больше 5
    И Перемещение курсор на "Приготовление пищи"
    Тогда Проверка: колиечства ссылок в подменю "Приготовление пищи" больше 5
      | 5 |

  @CheckElectricStoveCount
  Сценарий: Проверка, что количество электрических плит больше 100
    И Выполнен переход на страницу "Плиты и печи"
    И Выполнен переход по ссылке "Электрические плиты"
    Тогда Проверка, что количество электрических плит больше 100
      | 100 |