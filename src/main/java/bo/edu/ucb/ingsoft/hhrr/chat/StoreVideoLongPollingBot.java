package bo.edu.ucb.ingsoft.hhrr.chat;

import org.springframework.context.ApplicationContext;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StoreVideoLongPollingBot extends TelegramLongPollingBot {

    /**
     * Atributo que sirve para guardar el proceso actual de los diferentes usuarios.
     */
    private Map<Long, AbstractProcess> usersSession;
    private boolean test = false;
    private List<BotApiMethod> testMessages = new ArrayList<>();
    private ApplicationContext context;
    private static Logger LOGGER = LoggerFactory.getLogger(StoreVideoLongPollingBot.class);


    public StoreVideoLongPollingBot(ApplicationContext context) {
        this.context = context;
        usersSession = new HashMap<>();
    }

    public StoreVideoLongPollingBot(ApplicationContext context, boolean test) {
        this.context = context;
        this.test = test;
        usersSession = new HashMap<>();
    }

    @Override
    public String getBotUsername() {
        return "sergio_ucb_bot";
    }

    @Override
    public String getBotToken() {
        return "5166264710:AAHyZeqBaDGkfRzJVX3Ac7RrlRzbxuzJNvw";
    }

    public void sendMyMessage(BotApiMethod method) throws TelegramApiException {
        LOGGER.info("\n\\Enviando mensaje: ",method);
        if (test) {
            // no enviamos
            testMessages.add(method);
        } else {
            this.execute(method);
        }
    }

    @Override
    public void onUpdateReceived(Update update) {
        // Primero identifico al usuario por chat Id Long
        Long chatId = update.getMessage().getChatId();
        LOGGER.info("\n\\n===========> Recibiendo chatId: {}",chatId);


        // Busco si ya existe Proceso en el map userSession
        AbstractProcess currentProcess = usersSession.get(chatId);

        if (currentProcess == null) { // Primera vez que se contacto con nostros.

            LOGGER.info("\n\\Creando proceso para el  chatId: {}",chatId);
            // Debo crear el proceso por defecto
            currentProcess = new MenuPrincipal();
            usersSession.put(chatId, currentProcess);
            LOGGER.info("\n\\Derivando la conversación al proceso:  {}",currentProcess.getName());

            AbstractProcess nextProcess = currentProcess.handle(context, update, this);

            if (!nextProcess.equals(currentProcess)) { // Si el siguiente proceso es diferente lo iniciamos
                LOGGER.info("\n\\Creando proceso para el  chatId: {}",nextProcess.getName());

                nextProcess.handle(context, update, this);
            } else {
                LOGGER.info("\n\\No hay cambio de proceso, así que termina conversación: {}",chatId);

            }
            usersSession.put(chatId, nextProcess);

        } else { // Ya existe un proceso
            LOGGER.info("\n\\Continuamos el proceso para el  chatId: ",currentProcess.getName());

            AbstractProcess nextProcess = currentProcess.handle(context, update, this);

            if (!nextProcess.equals(currentProcess)) { // Si el siguiente proceso es diferente
                LOGGER.info("\n\\Iniciando siguiente proceso: {}",nextProcess.getName());
                nextProcess = nextProcess.handle(context, update, this);
            } else {
                LOGGER.info("\n\\No hay cambio de proceso, así que termina conversación {}",chatId);

            }
            usersSession.put(chatId, nextProcess);
        }

    }

    public List<BotApiMethod> getTestMessages() {
        return testMessages;
    }
}
