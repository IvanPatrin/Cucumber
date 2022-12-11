# language: ru
# encoding: utf-8
Функция: Первый кейс
  Предыстория:
    Дано Открыта страница "DNS"
    Когда Выведен заголовк страницы
    И Выведен текущий URL
    И Выведен размер окна
    И Выполнен переход на страницу "Бытовая техника"

  @AssertPageTitle
  Сценарий: Отображение текста Бытовая техника
    Тогда Проверка: Отображение текста Бытовая техника
      | Бытовая техника |

  @CheckTextKitchenAppliancesPage
  Сценарий: Отображение текста Техника для кухни
    И Выполнен переход по ссылке "Техника для кухни"
    Тогда Проверка: Отображение текста Техника для кухни
      | Техника для кухни|

  @CheckLinkMakeKitchen
  Сценарий: Отображение ссылки Собери свою кухню
    И Выполнен переход по ссылке "Техника для кухни"
    Тогда Проверка: Отображение ссылки Собрать свою кухню
      | Собрать свою кухню |

  @CheckCountKitchenAppliancesCategory
  Сценарий: Проверка, что количества категорий Техника для кухни больше чем 5
    И Выполнен переход по ссылке "Техника для кухни"
    Тогда Проверка: количества категорий Техника для кухни больше чем 5
      | 5 |