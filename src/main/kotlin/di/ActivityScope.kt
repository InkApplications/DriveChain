package di

/**
 * Service scope for services that are to be created/destroyed with each new activity.
 *
 * These services will get access to dependencies inside the activity class, such as the actionbar,
 * and the activity itself.
 */
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
annotation class ActivityScope