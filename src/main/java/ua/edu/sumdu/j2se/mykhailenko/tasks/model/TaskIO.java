package ua.edu.sumdu.j2se.mykhailenko.tasks.model;

import com.google.gson.Gson;

import java.io.*;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class TaskIO {
    public static void write(AbstractTaskList tasks, OutputStream out) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(out)) {
            dos.write(tasks.size());
            for (Task task : tasks) {
                dos.write(task.getTitle().length());
                dos.writeUTF(task.getId());
                dos.writeUTF(task.getTitle());
                dos.write(task.isActive() ? 1 : 0);
                dos.writeInt(task.getRepeatInterval());
                dos.writeLong(task.getStartTime().toEpochSecond(ZoneOffset.UTC));
                if (task.isRepeated()) {
                    dos.writeLong(task.getEndTime().toEpochSecond(ZoneOffset.UTC));
                }
            }
        }
    }

    public static void read(AbstractTaskList tasks, InputStream in) throws IOException {
        try (DataInputStream dis = new DataInputStream(in)) {
            int size = dis.read();
            Task task;
            String title, id;
            boolean active;
            int repeatInterval;
            LocalDateTime start, end;
            for (int i = 0; i < size; i++) {
                dis.read();
                id = dis.readUTF();
                title = dis.readUTF();
                active = (dis.read() == 1);
                repeatInterval = dis.readInt();
                start = LocalDateTime.ofEpochSecond(dis.readLong(), 0, ZoneOffset.UTC);
                if (repeatInterval > 0) {
                    end = LocalDateTime.ofEpochSecond(dis.readLong(), 0, ZoneOffset.UTC);
                    task = new Task(title, start, end, repeatInterval);
                } else {
                    task = new Task(title, start);
                }
                task.setActive(active);
                task.setId(id);
                tasks.add(task);
            }
        }
    }

    public static void writeBinary(AbstractTaskList tasks, File file) throws IOException {
        TaskIO.write(tasks,  new FileOutputStream(file));
    }

    public static void readBinary(AbstractTaskList tasks, File file) throws IOException {
        TaskIO.read(tasks, new FileInputStream(file));
    }

    public static void write(AbstractTaskList tasks, Writer out) throws IOException {
        Gson gson = new Gson();
        try {
            gson.toJson(tasks, out);
            out.flush();
        } finally {
            out.close();
        }
    }

    public static void read(AbstractTaskList tasks, Reader in) throws IOException {
        Gson gson = new Gson();
        try {
            AbstractTaskList taskList = gson.fromJson(in, tasks.getClass());
            in.close();
            for (Task task : taskList) {
                tasks.add(task);
            }
        } finally {
            in.close();
        }
    }

    public static void writeText(AbstractTaskList tasks, File file) throws IOException {
        TaskIO.write(tasks, new FileOutputStream(file));
    }

    public static void readText(AbstractTaskList tasks, File file) throws IOException {
        TaskIO.read(tasks, new FileInputStream(file));
    }
}
