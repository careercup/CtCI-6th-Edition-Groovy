package Ch04_TreesAndGraphs

import Ch04_TreesAndGraphs.utils.BiNode

/** Determine if a large binary tree is part of a way bigger one (their matched roots should be equal) */
class _04_10_CheckSubtree {
    /** Complexity: O(source.size + target.size) */
    static contains_withHash(BiNode source, BiNode target) {
        def (results, targetHash) = [[], eachWithHash(target) {}]
        eachWithHash(source) { int hash, BiNode node ->
            if (hash == targetHash && node == target)
                results.add(node)
        }
        !results.empty
    }
    private static eachWithHash(BiNode node, Closure closure) {
        if (!node) return 0
        def hash = Objects.hash(node.value,
                                eachWithHash(node.left, closure),
                                eachWithHash(node.right, closure))
        closure([hash, node])
        hash
    }

    /** Complexity: O(source.size * target.size) */
    static contains_withBfs(BiNode source, BiNode target) {
        for (def queue = [source] as ArrayDeque; !queue.empty;) {
            def value = queue.removeFirst()
            if (value == target)
                return true
            for (it in [value.left, value.right].findAll())
                queue.add(it)
        }
        false
    }
}
