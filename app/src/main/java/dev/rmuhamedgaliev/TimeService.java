package dev.rmuhamedgaliev;

import io.helidon.webserver.Routing;
import io.helidon.webserver.ServerRequest;
import io.helidon.webserver.ServerResponse;
import io.helidon.webserver.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class TimeService implements Service {

    /**
     * Инициализируем методы сервиса, и указываем пути для обращения
     * @param rules
     */
    @Override
    public void update(Routing.Rules rules) {
        rules
                .get("/", this::getUTCTime)
                .get("/{timezone}", this::getTimeInTimezone);
    }

    private void getUTCTime(ServerRequest request, ServerResponse response) {
        response.send(getTimeInZone("UTC"));
    }

    private void getTimeInTimezone(ServerRequest request, ServerResponse response) {
        String timezone = request.path().param("timezone").replace("-", "/");
        response.send(getTimeInZone(timezone));
    }

    private String getTimeInZone(String timeZone) {
        return LocalDateTime.now(ZoneId.of(timeZone)).format(DateTimeFormatter.ISO_DATE_TIME);
    }
}