package org.example.spec;

/**
 * List는 ArrayList, SingleLinkedList, DoubleLinkedList에 의해 구현됩니다.
 * @Param <E> the type of elements in this list
 */
public interface List<E> {
    /**
     * 리스트에 요소를 추가합니다.
     *
     * @param value 리스트에 추가할 요소
     * @return 리스트에서 중복을 허용하지 않을 경우에
     * 리스트에 이미 중복되는 요소가 있을 경우 {@Code false}를 반환하고,
     * 중복되는 요소가 없을 경우 {@Code true}를 반환
     */
    boolean add(E value);

    /**
     * 리스트의 원하는 위치에 요소를 추가한다.
     *
     * @param index 리스트에 값을 넣을 위치
     * @param value 리스트에 넣고자 하는 값
     */
    void add(int index, E value);

    /**
     * 리스트의 index 위치에 있는 요소를 삭제합니다.
     *
     * @param index 리스트에서 삭제할 원소의 위치
     * @return 삭제된 요소를 반환
     */
    E remove(int index);

    /**
     * 리스트에서 특정 요소를 삭제합니다.
     * 동일한 요소가 여러 개일 경우 가장 처음 발견한 요소만 삭제됩니다.
     *
     * @param value 리스트에서 삭제할 요소
     * @return 리스트에 삭제할 요소가 없거나 삭제에 실패할 경우 {@Code false}를 반환하고
     * 삭제에 성공할 경우 {@Code true}를 반환
     */
    boolean remove(E value);

    /**
     * 리스트에서 특정 요소를 반환합니다.
     *
     * @param index 리스트에서 접근할 원소의 위치
     * @return 리스트의 index 위치에 있는 요소 반환
     */
    E get(int index);

    /**
     * 리스트에서 특정 위치에 있는 요소를 새 요소로 대체합니다.
     *
     * @param index 리스트에서 접근할 원소의 위치
     * @param value 대체할 원소
     */
    void set(int index, E value);

    /**
     * 리스트에 특정 요소가 있는지 확인합니다.
     *
     * @param value 리스트에서 찾고 싶은 값
     * @return 리스트에 찾고 싶은 값이 있다면 {@Code true}, 없을 경우 {@Code false}를 반환
     */
    boolean contains(E value);

    /**
     * 리스트에 특정 요소가 몇 번째 위치에 있는지 반환합니다.
     *
     * @param value 리스트에서 위치를 알고 싶은 값
     * @return 리스트에서 찾고 싶은 값의 위치를 반환합니다.
     * 만약 여러 개라면 처음 일치하는 요소의 위치를 반환합니다.
     * 만약 일치하는 요소가 없을 경우 {@Code -1}을 반환합니다.
     */
    int indexOf(E value);

    /**
     * 리스트에 요소가 비어있는지 여부를 반환합니다.
     *
     * @return 리스트에 요소가 없을 경우 {@Code true}, 요소가 있을 경우 {@Code false}를 반환
     */
    boolean isEmpty();

    /**
     * 리스트에 있는 요소를 모두 삭제합니다.
     */
    void clear();

    /**
     * @return 리스트의 요소 수를 반환합니다.
     */
    int size();
}
