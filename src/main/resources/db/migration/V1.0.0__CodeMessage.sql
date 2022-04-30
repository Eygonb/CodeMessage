create extension if not exists uuid_ossp;

create table uploaded_files (
    id uuid default uuid_generate_v4() not null,
    file_name text not null,
    file_path text not null,
    primary key (id)
);

create table chats (
    id uuid default uuid_generate_v4() not null,
    type text not null,
    img_id uuid,
    chat_name text,
    primary key (id),
    foreign key (img_id) references uploaded_files(id)
);

create table accounts (
    id uuid default uuid_generate_v4() not null,
    username text not null,
    email text not null,
    password text not null,
    type text not null,
    title text,
    img_id uuid,
    primary key (id),
    foreign key (img_id) references uploaded_files(id),
    unique (username),
    unique (email)
);

create table messages (
    id uuid default uuid_generate_v4() not null,
    type text not null,
    text_msg text not null,
    chat_id uuid not null,
    user_id uuid not null,
    time_msg timestamp with time zone not null,
    was_changed boolean not null,
    was_read boolean not null,
    reply uuid,
    attachment_id uuid,
    primary key (id),
    foreign key (chat_id) references chats(id),
    foreign key (user_id) references accounts(id),
    foreign key (reply) references messages(id),
    foreign key (attachment_id) references uploaded_files(id)
);

create table black_list (
    owner_id uuid not null,
    user_id uuid not null,
    primary key (owner_id, user_id),
    foreign key (owner_id) references accounts(id),
    foreign key (user_id) references accounts(id)
);

create table user_chats (
    user_id uuid not null,
    chat_id uuid not null,
    type text not null,
    primary key (user_id, chat_id),
    foreign key (user_id) references accounts(id),
    foreign key (chat_id) references chats(id)
);

create table reports (
    id uuid default uuid_generate_v4() not null,
    user_id uuid not null,
    reason text not null,
    primary key (id),
    foreign key (user_id) references accounts(id)
);

create table unread_msgs (
    user_id uuid not null,
    msg_id uuid not null,
    primary key (user_id, msg_id),
    foreign key (user_id) references accounts(id),
    foreign key (msg_id) references messages(id)
);

create table langs (
    id uuid default uuid_generate_v4() not null,
    lang_name text not null,
    file_type text not null,
    primary key (id)
);

create table syntaxes (
    lang_id uuid not null,
    keyword text not null,
    color character varying(6)[] not null,
    primary key (lang_id, keyword),
    foreign key (lang_id) references langs(id)
);