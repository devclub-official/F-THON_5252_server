-- 카테고리 데이터 삽입
INSERT INTO category (code, name)
VALUES ('TOP', '상의'),
       ('OUTER', '아우터'),
       ('BOTTOM', '바지'),
       ('ONEPIECE', '원피스/스커트'),
       ('SHOES', '신발'),
       ('ACC', '액세서리/패션소품');

-- 의류 유형 데이터 삽입 (상의)
INSERT INTO clothing_type (category_id, code, name, image_url)
VALUES (1, 'TOP_TSHIRT_SHORT', '반팔 티셔츠', 'https://example.com/images/short_tshirt.jpg'),
       (1, 'TOP_TSHIRT_LONG', '긴팔 티셔츠', 'https://example.com/images/long_tshirt.jpg'),
       (1, 'TOP_SWEATSHIRT', '맨투맨', 'https://example.com/images/sweatshirt.jpg'),
       (1, 'TOP_HOODIE', '후드 티셔츠', 'https://example.com/images/hoodie_tshirt.jpg'),
       (1, 'TOP_SHIRT', '셔츠', 'https://example.com/images/shirt.jpg'),
       (1, 'TOP_POLO', '카라 티셔츠/폴로', 'https://example.com/images/polo.jpg'),
       (1, 'TOP_KNIT', '니트/스웨터', 'https://example.com/images/sweater.jpg'),
       (1, 'TOP_SLEEVELESS', '민소매/나시', 'https://example.com/images/sleeveless.jpg');

-- 의류 유형 데이터 삽입 (아우터)
INSERT INTO clothing_type (category_id, code, name, image_url)
VALUES (2, 'OUTER_HOODIE_ZIP', '후드 집업', 'https://example.com/images/hoodie_zip.jpg'),
       (2, 'OUTER_BOMBER', '항공점퍼(블루종)', 'https://example.com/images/bomber.jpg'),
       (2, 'OUTER_LEATHER', '가죽 재킷', 'https://example.com/images/leather_jacket.jpg'),
       (2, 'OUTER_CARDIGAN', '카디건', 'https://example.com/images/cardigan.jpg'),
       (2, 'OUTER_DENIM', '데님 재킷', 'https://example.com/images/denim_jacket.jpg'),
       (2, 'OUTER_BLAZER', '정장 재킷/블레이저', 'https://example.com/images/blazer.jpg'),
       (2, 'OUTER_STADIUM', '스타디움 재킷', 'https://example.com/images/stadium_jacket.jpg'),
       (2, 'OUTER_WINDBREAKER', '바람막이/윈드브레이커', 'https://example.com/images/windbreaker.jpg'),
       (2, 'OUTER_ANORAK', '아노락', 'https://example.com/images/anorak.jpg'),
       (2, 'OUTER_TRAINING', '트레이닝 자켓', 'https://example.com/images/training_jacket.jpg'),
       (2, 'OUTER_LIGHT_COAT', '가벼운 코트', 'https://example.com/images/light_coat.jpg'),
       (2, 'OUTER_SAFARI', '사파리 재킷', 'https://example.com/images/safari_jacket.jpg'),
       (2, 'OUTER_VEST', '조끼/베스트', 'https://example.com/images/vest.jpg'),
       (2, 'OUTER_SHORT_PADDING', '숏패딩', 'https://example.com/images/short_padding.jpg'),
       (2, 'OUTER_MUSTANG', '무스탕', 'https://example.com/images/mustang.jpg'),
       (2, 'OUTER_FLEECE', '플리스', 'https://example.com/images/fleece.jpg'),
       (2, 'OUTER_COAT', '코트', 'https://example.com/images/coat.jpg'),
       (2, 'OUTER_LONG_PADDING', '롱패딩', 'https://example.com/images/long_padding.jpg'),
       (2, 'OUTER_PADDING_VEST', '패딩 조끼', 'https://example.com/images/padding_vest.jpg');

-- 의류 유형 데이터 삽입 (바지)
INSERT INTO clothing_type (category_id, code, name, image_url)
VALUES (3, 'BOTTOM_JEANS', '청바지/데님', 'https://example.com/images/jeans.jpg'),
       (3, 'BOTTOM_JOGGER', '트레이닝/조거 팬츠', 'https://example.com/images/jogger.jpg'),
       (3, 'BOTTOM_COTTON', '면바지', 'https://example.com/images/cotton_pants.jpg'),
       (3, 'BOTTOM_SLACKS', '정장 바지/슬랙스', 'https://example.com/images/slacks.jpg'),
       (3, 'BOTTOM_SHORTS', '반바지', 'https://example.com/images/shorts.jpg'),
       (3, 'BOTTOM_LEGGINGS', '레깅스', 'https://example.com/images/leggings.jpg'),
       (3, 'BOTTOM_JUMPSUIT', '점프수트/오버올', 'https://example.com/images/jumpsuit.jpg');

-- 의류 유형 데이터 삽입 (원피스/스커트)
INSERT INTO clothing_type (category_id, code, name, image_url)
VALUES (4, 'ONEPIECE_DRESS', '원피스', 'https://example.com/images/dress.jpg'),
       (4, 'ONEPIECE_SKIRT', '스커트', 'https://example.com/images/skirt.jpg');

-- 의류 유형 데이터 삽입 (신발)
INSERT INTO clothing_type (category_id, code, name, image_url)
VALUES (5, 'SHOES_SNEAKERS', '스니커즈/운동화', 'https://example.com/images/sneakers.jpg'),
       (5, 'SHOES_WINTER', '방한화/털신', 'https://example.com/images/winter_shoes.jpg'),
       (5, 'SHOES_BOOTS', '부츠', 'https://example.com/images/boots.jpg'),
       (5, 'SHOES_FORMAL', '구두', 'https://example.com/images/dress_shoes.jpg'),
       (5, 'SHOES_SANDALS', '샌들/슬리퍼', 'https://example.com/images/sandals.jpg'),
       (5, 'SHOES_SPORTS', '스포츠화', 'https://example.com/images/sports_shoes.jpg');

-- 의류 유형 데이터 삽입 (액세서리/패션소품)
INSERT INTO clothing_type (category_id, code, name, image_url)
VALUES (6, 'ACC_HAT', '모자', 'https://example.com/images/hat.jpg'),
       (6, 'ACC_SCARF', '목도리/스카프', 'https://example.com/images/scarf.jpg'),
       (6, 'ACC_SOCKS', '양말', 'https://example.com/images/socks.jpg'),
       (6, 'ACC_GLASSES', '선글라스/안경', 'https://example.com/images/glasses.jpg');

-- 추천 요청 데이터 삽입
INSERT INTO outfit_request (gender, age, style_preference, purpose,
                            current_latitude, current_longitude, current_location_name,
                            destination_latitude, destination_longitude, destination_location_name,
                            request_time)
VALUES ('male', 25, '캐주얼', '데이트',
        37.5665, 126.9780, '서울시 강남구',
        37.5559, 126.9723, '서울시 용산구',
        '2025-04-18 14:30:00'),
       ('female', 30, '모던', '출근',
        37.5665, 126.9780, '서울시 강남구',
        37.5113, 127.0576, '서울시 송파구',
        '2025-04-18 08:15:00'),
       ('male', 22, NULL, '여행',
        35.1796, 129.0756, '부산시 해운대구',
        35.1545, 129.0600, '부산시 남구',
        '2025-04-18 10:45:00');

-- 날씨 예보 데이터 삽입
-- 첫 번째 요청의 날씨 예보
INSERT INTO weather_forecast (request_id, is_destination, forecast_time, temperature,
                              weather_status, humidity, precipitation, wind_speed)
VALUES (1, FALSE, '2025-04-18 14:30:00', 17.5, '맑음', 55.0, 0.0, 3.2), -- 현재 위치, 현재 시간
       (1, TRUE, '2025-04-18 15:00:00', 17.2, '맑음', 56.0, 0.0, 3.0);
-- 목적지, 도착 예상 시간

-- 두 번째 요청의 날씨 예보
INSERT INTO weather_forecast (request_id, is_destination, forecast_time, temperature,
                              weather_status, humidity, precipitation, wind_speed)
VALUES (2, FALSE, '2025-04-18 08:15:00', 16.8, '흐림', 70.0, 20.0, 2.5), -- 현재 위치, 현재 시간
       (2, TRUE, '2025-04-18 09:00:00', 16.5, '흐림', 71.0, 15.0, 2.6);
-- 목적지, 도착 예상 시간

-- 세 번째 요청의 날씨 예보
INSERT INTO weather_forecast (request_id, is_destination, forecast_time, temperature,
                              weather_status, humidity, precipitation, wind_speed)
VALUES (3, FALSE, '2025-04-18 10:45:00', 19.2, '맑음', 45.0, 0.0, 3.5), -- 현재 위치, 현재 시간
       (3, TRUE, '2025-04-18 11:30:00', 19.5, '맑음', 44.0, 0.0, 3.6);
-- 목적지, 도착 예상 시간

-- 사용자 선택 데이터 삽입
INSERT INTO user_selection (
    request_id, gender, age, location, weather_status, temperature,
    top_code, bottom_code, outer_code,
    selection_time
) VALUES
      (
          1, 'male', 25, '서울시 강남구', '맑음', 17.5,
          'TOP_TSHIRT_SHORT', 'BOTTOM_JEANS', 'OUTER_HOODIE_ZIP',
          '2025-04-18 14:35:00'
      ),
      (
          2, 'female', 30, '서울시 강남구', '흐림', 16.8,
          'TOP_SHIRT', 'BOTTOM_SLACKS', 'OUTER_BLAZER',
          '2025-04-18 08:20:00'
      ),
      (
          3, 'male', 22, '부산시 해운대구', '맑음', 19.2,
          'TOP_POLO', 'BOTTOM_SHORTS', NULL,
          '2025-04-18 10:50:00'
      );