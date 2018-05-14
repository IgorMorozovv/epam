package mail.logging;

public class LoggingMessages {

    public final static String START_TEST_MESSAGE = "Начало выполенения теста ";
    public final static String END_TEST_MESSAGE = "Конец выполнения теста ";
    public static final String FILL_FIELDS_MESSAGE = "Заполнение полей: получатель, тема, сообщение ";
    public static final String REFRESH_MAIL_MESSAGE = "Обновление почты ";
    public static final String DELETE_DRAFT_MESSAGE = "Удаление всех сообщений ";
    public static final String SAVE_DRAFT_MESSAGE = "Сохранение черновика ";
    public static final String GO_TO_MESSAGE = "Переход на ";
    public static final String INBOX_MESSAGE = "Входящие ";
    public static final String CKICK_USER_ICON_MESSAGE = "Нажатие на иконку пользователя";
    public static final String LOGOUT_MESSAGE = "Выход из почты";
    public static final String SENDING_MESSAGE = "Отправка сообщения";
    public static final String DELETE_SENT_LETTERS_MESSAGE = "Удаление всех отправленных сообщений";
    public static final String TO_FIRST_DRAFT_MESSAGE = "Открытие первого письма в папке Черновики";
    public static final String GET_DATA_MESSAGE = "Получение данных для теста из файла";

    // Сообщения перед assert
    public static final String ASSERT_LOGGING_MESSAGE = "Проверка отображения страницы Входящие после входа в почту";
    public static final String ASSERT_FILL_FIELDS_MESSAGE = "Проверка корректности заполненных полей";
    public static final String ASSERT_SEND_LETTER_MESSAGE = "Проверка отправления сообщения - всплывающее окно с текстом \"Сообщение тправлено\"";
    public static final String ASSERT_TRANSFER_LETTER_MESSAGE = "Проверка переноса черновика в папку Удалённые";
    public static final String ASSERT_LOGOUT_MESSAGE = "Проверка выхода - переход на главную страницу яндекса";
    public static final String ASSERT_CREATE_DRAFT_MESSAGE = "Проверка сохранения письма - появление текста \"Сохранено\"";

    // Сообщения, если проверка провалилась
    public static final String FAILURE_VERIFY_LOGIN_MESSAGE = "Не удалось войти в почту";
    public static final String FAILURE_VERIFY_LOOUT_MESSAGE = "Выход из почты не удался";
    public static final String FAILURE_VERIFY_CREATE_DRAFT_MESSAGE = "Сообщение о сохранении не появилось";
    public static final String FAILURE_VERIFY_SEND_LETTER_MESSAGE = "Сообщение не отправлено";
    public static final String FAILURE_VERIFY_TRANSFER_DRAFT_MESSAGE = "Не удалось перенести сообщение в папку Удалённые";
    public static final String FAILURE_VERIFY_FIELDS_DRAFT_MESSAGE = "Значения не совпадают";

    public static final String ENTER_PAGE_MESSAGE = "Страница входа, заполнение полей";
    public static final String ENTER_BUTTON_CLICK_MESSAGE = "Нажатие кнопки вход";

}
