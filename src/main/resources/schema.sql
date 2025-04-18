-- 카테고리 테이블 (대분류)
CREATE TABLE category
(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    code       VARCHAR(20) NOT NULL UNIQUE,
    name       VARCHAR(50) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 의류 유형 테이블 (소분류)
CREATE TABLE clothing_type
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    category_id INT          NOT NULL,
    code        VARCHAR(30)  NOT NULL UNIQUE,
    name        VARCHAR(100) NOT NULL,
    image_url   VARCHAR(255),
    created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (category_id) REFERENCES category (id)
);

-- 사용자 요청 테이블
CREATE TABLE outfit_request
(
    id                        BIGINT AUTO_INCREMENT PRIMARY KEY,
    gender                    VARCHAR(20) NOT NULL,
    age                       INT         NOT NULL,
    style_preference          VARCHAR(50),
    purpose                   VARCHAR(50),
    -- 현재 위치 정보
    current_latitude DOUBLE,
    current_longitude DOUBLE,
    current_location_name     VARCHAR(100),
    -- 목적지 정보
    destination_latitude DOUBLE,
    destination_longitude DOUBLE,
    destination_location_name VARCHAR(100),
    request_time              TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- 날씨 예보 테이블
CREATE TABLE weather_forecast
(
    id             BIGINT AUTO_INCREMENT PRIMARY KEY,
    request_id     BIGINT    NOT NULL,
    is_destination BOOLEAN   NOT NULL, -- false: 현재 위치, true: 목적지
    forecast_time  TIMESTAMP NOT NULL, -- 예보 시점 (현재, 도착 시간, 등)
    temperature DOUBLE,
    weather_status VARCHAR(50),
    humidity DOUBLE,
    precipitation DOUBLE,              -- 강수 확률 (%)
    wind_speed DOUBLE,
    created_at     TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (request_id) REFERENCES outfit_request (id),
    UNIQUE KEY unique_request_location_time (request_id, is_destination, forecast_time)
);

-- 사용자 선택 테이블
CREATE TABLE user_selection
(
    id             BIGINT AUTO_INCREMENT PRIMARY KEY,
    request_id     BIGINT       NOT NULL,
    gender         VARCHAR(20)  NOT NULL,                           -- 성별
    age            INT          NOT NULL,                           -- 나이
    location       VARCHAR(100) NOT NULL,                           -- 위치
    weather_status VARCHAR(50),                                     -- 날씨 상태
    temperature DOUBLE,                                             -- 온도

    -- 선택된 의류 정보
    top_code       VARCHAR(30),                                     -- 상의 코드
    bottom_code    VARCHAR(30),                                     -- 하의 코드
    outer_code     VARCHAR(30),                                     -- 아우터 코드
    shoes_code     VARCHAR(30),                                     -- 신발 코드
    accessory_code VARCHAR(30),                                     -- 액세서리 코드

    selection_time TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP, -- 선택 시간

    FOREIGN KEY (request_id) REFERENCES outfit_request (id)
);

-- 인덱스 추가
CREATE INDEX idx_outfit_request_current_location ON outfit_request (current_latitude, current_longitude);
CREATE INDEX idx_outfit_request_destination ON outfit_request (destination_latitude, destination_longitude);
CREATE INDEX idx_outfit_request_purpose ON outfit_request (purpose);
CREATE INDEX idx_clothing_type_category ON clothing_type (category_id);
CREATE INDEX idx_weather_forecast_request ON weather_forecast (request_id, is_destination);
CREATE INDEX idx_user_selection_request ON user_selection (request_id);
CREATE INDEX idx_user_selection_location ON user_selection (location);
CREATE INDEX idx_user_selection_gender_age ON user_selection (gender, age);
CREATE INDEX idx_user_selection_weather ON user_selection (weather_status, temperature);
CREATE INDEX idx_user_selection_items ON user_selection (top_code, bottom_code, outer_code);
CREATE INDEX idx_user_selection_time ON user_selection (selection_time);