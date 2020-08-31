# hibernate-tools-demo

Run `docker-compose up -d` to start a MySQL instance in the background

Add the following tables to your MySQL instance.

```sql
CREATE TABLE users (
    id INT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    is_active BOOLEAN NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE users ADD CONSTRAINT UC_users UNIQUE (email);

CREATE TABLE user_addresses (
	id INT NOT NULL AUTO_INCREMENT,
    address1 VARCHAR(100) NOT NULL,
    address2 VARCHAR(100) NOT NULL,
    city VARCHAR(50) NOT NULL,
    state VARCHAR(50) NOT NULL,
    country VARCHAR(50) NOT NULL,
    user_id INT NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE user_addresses ADD CONSTRAINT FK_user_addresses_user_id FOREIGN KEY (user_id) REFERENCES users (id);
```

Run `mvn hibernate-tools:hbm2java` to convert database tables into JPA entities