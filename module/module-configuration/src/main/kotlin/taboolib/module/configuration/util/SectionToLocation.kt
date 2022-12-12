@file:Isolated

package taboolib.module.configuration.util

import taboolib.common.Isolated
import taboolib.common.util.Location
import taboolib.library.configuration.ConfigurationSection

/**
 * 设置坐标
 *
 * @param path 路径
 * @param location 坐标
 */
fun ConfigurationSection.setLocation(path: String, location: Location) {
    set(path, mapOf(
        "world" to location.world,
        "x" to location.x,
        "y" to location.y,
        "z" to location.z,
        "yaw" to location.yaw,
        "pitch" to location.pitch,
    ))
}

/**
 * 获取坐标
 *
 * @param path 路径
 * @return 坐标
 */
fun ConfigurationSection.getLocation(path: String): Location? {
    getConfigurationSection(path)?.let { section ->
        return Location(
            section.getString("world"),
            section.getDouble("x"),
            section.getDouble("y"),
            section.getDouble("z"),
            section.getDouble("yaw").toFloat(),
            section.getDouble("pitch").toFloat()
        )
    } ?: return null
}