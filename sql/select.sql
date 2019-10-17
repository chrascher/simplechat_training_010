

CREATE TABLE chats.account2(
   user_id serial PRIMARY KEY,
   username VARCHAR (50) UNIQUE NOT NULL,
   password VARCHAR (50) NOT NULL,
   email VARCHAR (355) UNIQUE NOT NULL,
   created_on TIMESTAMP DEFAULT NOW(),
   last_login TIMESTAMP DEFAULT NOW()
);


ALTER TABLE chats.account ALTER COLUMN created_on SET DEFAULT now();
ALTER TABLE chats.account ALTER COLUMN last_login SET DEFAULT now();