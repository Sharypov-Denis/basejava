import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[3];
    int size = 0;


    void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    void save(Resume r) {
        storage[size] = r;
        size++;
    }

    Resume get(String uuid) {
        Resume resume = null;
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                resume = storage[i];
                break;
            }
        }
        return resume;
    }

    void delete(String uuid) {
        Resume[] resume = new Resume[size];
        int itemNewArray = 0;//номер элемента в новом массиве для записи
        boolean deletedItem = false;//если будет удален элемент - то true
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                storage[i] = null;
                deletedItem = true;
            } else {//если не было удаление элементы, переписываем элементы в новый массив
                resume[itemNewArray] = storage[i];
                itemNewArray++;//добавляем 1 к номеру,поможет если был удален элемент,
                //чтобы в новый массив значение добавлять с самого начала без пропусков
            }
        }
        if (deletedItem) size--;//если был удален элемент - уменьшаем кол-во резюме

        storage = Arrays.stream(resume).toArray(Resume[]::new);

        /*
        storage = new Resume[size];
        for (int i = 0; i < size; i++) {
            storage[i] = resume[i];
        }
         */
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
