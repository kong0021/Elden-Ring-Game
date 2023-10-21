package game.Enemies;

public enum EnemyType {
    SKELETON,
    CANINE,
    AQUAMARINE;

    public static boolean matchEnum(Enum enums){
        for (EnemyType enemyType : EnemyType.values()){
            if (enums == enemyType){
                return true;
            }
        }
        return false;
    }
}
