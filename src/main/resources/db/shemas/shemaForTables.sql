CREATE TABLE railway_stations
(
    id             BIGSERIAL PRIMARY KEY,
    name           VARCHAR(255) UNIQUE,
    status_station VARCHAR(55),
    free_places    INTEGER
);


CREATE TABLE trains
(
    id                 BIGSERIAL PRIMARY KEY,
    name               VARCHAR(100),
    type               VARCHAR(55),
    status_train       VARCHAR(55),
    version            VARCHAR(100),
    number             BIGINTEGER UNIQUE,
    railway_station_id BIGINT,
    road_id            BIGINT,
    CONSTRAINT fk_train_road FOREIGN KEY (road_id)
        REFERENCES roads (id)
        ON DELETE SET NULL,
    CONSTRAINT fk_train_station FOREIGN KEY (railway_station_id)
        REFERENCES railway_stations (id)
        ON DELETE SET NULL

);
CREATE TABLE roads
(
    id          BIGSERIAL PRIMARY KEY,
    name        VARCHAR(100) UNIQUE,
    status_road VARCHAR(55)
);
CREATE TABLE road_station
(
    road_id    BIGINT NOT NULL,
    station_id BIGINT NOT NULL,
    PRIMARY KEY (road_id, station_id),
    CONSTRAINT fk_road FOREIGN KEY (road_id)
        REFERENCES roads (id) ON DELETE CASCADE,
    CONSTRAINT fk_station FOREIGN KEY (station_id)
        REFERENCES railway_stations (id) ON DELETE CASCADE

);