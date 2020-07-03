import netscape.security.UserTarget;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int size = 0;


    void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    void save(Resume r) {
        storage[size] = r;
        size++;
    }

    Resume get(String uuid) {
        Resume search = null;
        for (Resume resume : storage) {
            if (resume.getUuid().equals(uuid)) {
                search = resume;
                break;
            }
        }
        return search;
    }

    void delete(String uuid) {
        boolean delete = false;
        for (int i = 0; i < size + 1; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                storage[i] = storage[i + 1];
                size--;
                delete = true;
            }
            if (delete) {
                storage[i] = storage[i + 1];
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] resumeAll = new Resume[size];
        for (int i = 0; i < size; i++) {
            resumeAll[i] = storage[i];
        }
        return resumeAll;
    }

    int size() {
        return size;
    }
}
