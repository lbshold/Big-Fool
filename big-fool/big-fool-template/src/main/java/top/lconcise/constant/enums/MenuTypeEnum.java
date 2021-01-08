package top.lconcise.constant.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 菜单类型.
 *
 * @author liusj
 * @date 2021/1/6
 */
@Getter
@RequiredArgsConstructor
public enum MenuTypeEnum {

    LEFT_MENU("0", "left"),
    TOP_MENU("2", "top"),
    BUTTON("1", "button");

    /**
     * 类型.
     */
    private final String type;

    /**
     * 描述.
     */
    private final String description;
}
